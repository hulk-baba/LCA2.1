# Least-Common-Ancestor
## Prerequisite
We need jgrapht. Since this is a Maven project, I have already added pom.xml to fetch dependencies.

## Working
We have a dot file which contains a graph and we need to find all the closest ancestor of two given nodes as command line argument. Since we intend to find all the LCAs of two given nodes, expected graph is a DAG. So you can alter fileName in LeastCommonAncestor class and choose your own dot file. Remember to add only DAG.

## Description of Files
LeastCommonAncestor contains a method `allLcas` which uses `DOTImporter` class to parse the dot file as graph and then uses
`findLcas` from `NaiveLcaFinder`. We need to make sure the input dot file contains a DAG.
My current dot file which renders following graph:
![demo4 dot](https://user-images.githubusercontent.com/13489709/36247028-61052a0c-1258-11e8-9564-7d4c8ae8630d.png)

I am yet to write test cases, but gives me following output for `Tyrion Cersei`


![tyrioncer](https://user-images.githubusercontent.com/13489709/36311599-ce50199c-1351-11e8-899e-039e951137b7.png)


and `Joffrey Tommen`
![joffreyt](https://user-images.githubusercontent.com/13489709/36311569-b31de91a-1351-11e8-9e02-5e9a5cb70636.png)



