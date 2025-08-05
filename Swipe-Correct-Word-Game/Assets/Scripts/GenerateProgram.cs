using UnityEngine;
using System.Collections;
using WordShufflerConsoleTest;

public class GenerateProgram : MonoBehaviour 
{
	// PROGRAMI BAŞLATAN KISIM
	void Start () 
	{
		Program.Instance.Generate();
	}
}