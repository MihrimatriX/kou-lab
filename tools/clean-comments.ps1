#Requires -Version 5.1
param(
  [string]$Path = ".",
  [string]$BackupDir = "",
  [switch]$WhatIf
)

function Get-IsExcludedPath {
  param([string]$FullName)
  $excludeDirs = @(
    "\.git\", "node_modules\", "bin\", "obj\", "out\", "dist\", "build\", "target\", "libs\", "__pycache__\",
    "packages\", "Tess4J\\lib\", "android\\build\", "ios\\build\"
  )
  foreach ($d in $excludeDirs) { if ($FullName -imatch [regex]::Escape($d)) { return $true } }
  return $false
}

function Remove-CommentsFromContent {
  param([string]$Content, [string]$Extension)

  $result = $Content

  switch -Regex ($Extension) {
    '\\.(java|c|cpp|h|cs|js|ts|jsx|tsx|php)$' {
      # Preserve top-of-file license/copyright block if present
      $licensePattern = '^(?<lead>\s*)/\*([\s\S]*?)\*/'
      $licenseMatch = [regex]::Match($result, $licensePattern, 'Multiline')
      $preserveLicense = $false
      if ($licenseMatch.Success) {
        $blockText = $licenseMatch.Groups[0].Value
        if ($blockText -match '(?i)license|copyright') { $preserveLicense = $true }
      }

      # Remove block comments (/* ... */) that occupy full lines
      $blockPattern = '^[ \t]*/\*[\s\S]*?\*/[ \t]*\r?\n?'
      $tmp = [regex]::Replace($result, $blockPattern, '', 'Multiline')
      if ($preserveLicense -and $licenseMatch.Success) {
        # Reinsert preserved license at top if removed
        if (-not ($tmp -like ($licenseMatch.Groups[0].Value + '*'))) {
          $tmp = $licenseMatch.Groups[0].Value + "`r`n" + $tmp
        }
      }
      $result = $tmp

      # Remove full-line // comments
      $result = [regex]::Replace($result, '^[ \t]*//.*\r?$', '', 'Multiline')

      # Remove full-line # comments in PHP (avoid shebang-like)
      $result = [regex]::Replace($result, '^[ \t]*#(?!!|.*coding:).*$','', 'Multiline')
    }
    '\\.(py)$' {
      # Keep shebang and encoding line
      $result = [regex]::Replace($result, '^(?!#\!).*$', { param($m) $m.Value }, 'Multiline')
      $result = [regex]::Replace($result, '^[ \t]*#(?!!|.*coding:).*$','', 'Multiline')
    }
    default {
      return $Content
    }
  }

  # Collapse multiple blank lines
  $result = [regex]::Replace($result, '(\r?\n)[ \t]*(\r?\n)+', "`$1", 'Multiline')
  return $result
}

function Process-File {
  param([IO.FileInfo]$File)
  if (Get-IsExcludedPath -FullName $File.FullName) { return }

  $ext = $File.Extension.ToLowerInvariant()
  $supported = @('.java','.c','.cpp','.h','.cs','.js','.ts','.jsx','.tsx','.php','.py')
  if ($supported -notcontains $ext) { return }

  try {
    $original = [IO.File]::ReadAllText($File.FullName)
  } catch { return }

  $cleaned = Remove-CommentsFromContent -Content $original -Extension $ext
  if ($cleaned -ne $original) {
    if ($WhatIf) {
      Write-Host "[DRY-RUN] Would clean: $($File.FullName)" -ForegroundColor Yellow
      return
    }
    if ($BackupDir) {
      $dest = Join-Path $BackupDir ($File.FullName.Substring((Resolve-Path $Path).Path.Length).TrimStart('\','/'))
      $destDir = Split-Path $dest -Parent
      New-Item -ItemType Directory -Force -Path $destDir | Out-Null
      [IO.File]::WriteAllText($dest, $original)
    }
    [IO.File]::WriteAllText($File.FullName, $cleaned)
    Write-Host "Cleaned: $($File.FullName)" -ForegroundColor Green
  }
}

$root = Resolve-Path $Path
if (-not $BackupDir) {
  $stamp = (Get-Date).ToString('yyyyMMdd-HHmmss')
  $BackupDir = Join-Path $root ".backups/comments-$stamp"
}
if (-not $WhatIf) { New-Item -ItemType Directory -Force -Path $BackupDir | Out-Null }

Get-ChildItem -Path $root -Recurse -File |
  ForEach-Object { Process-File -File $_ }

Write-Host "Done." -ForegroundColor Cyan

