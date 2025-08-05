#include <iostream>
#include <fstream>
#include <vector>
#include <sstream>
#include <chrono>
#include "huffman.h"
#include "fixedhuffman.h"
#include "deflate.h"
#include "lz77.h"

using namespace std;

string readFile(string path);
string inputPath="D:\\test\\input.txt";
string lzoutPath="D:\\test\\lzout.txt";

map<char,int> frekansbulucu(string metin);

int main()
{
    deflate(readFile(inputPath),256,256,lzoutPath);
}

string readFile(string path)
{
    ifstream ifs;
    string line;
    ifs.open(path.c_str());
    string fileStr="";

    while (getline(ifs,line))
    {
        fileStr+=line;
    }

    ifs.close();
    return fileStr;
}
