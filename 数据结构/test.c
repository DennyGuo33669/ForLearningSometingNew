#include <stdio.h>
#include <stdlib.h>

#include <iostream>

using namespace std;

#define INFINITY 65535

#define MAX_VERTEX_NUM 100

typedef int VertexType;

int num = 0;

typedef struct ArcNode {
      int adjvex;
         //邻接顶点的标号
 
    int weight;
       //权重
 
    ArcNode *nextarc;

} ArcNode;
     //边表

    typedef struct {
      VertexType data;  // VertexType可以写成结构体类型存储信息

      ArcNode *firstarc;

} VNode;
     //顶点数组

    typedef struct  {
      VNode adjlist[MAX_VERTEX_NUM];

      int v, e;
}
ALGraph;

void CreateALGraph(ALGraph &G)     //创建邻接表

{
      int i, j, k;

      ArcNode *e;

      printf("输入顶点数和边数：\n");

      scanf("%d%d", &G.v, &G.e);

      for (i = 0; i < G.v; i++)
 
    {
             //scanf("%d",&G.adjlist[i].data);
 
        G.adjlist[i].firstarc = NULL;

       
  }

      for (k = 0; k < G.e; k++)
 
    {
            printf("输入边(vi,vj)上的顶点序号：\n");

            scanf("%d%d", &i, &j);

            e = (ArcNode *)malloc(sizeof(ArcNode));

            e->adjvex = j;

            e->nextarc = G.adjlist[i].firstarc;

            G.adjlist[i].firstarc = e;

            /*e=(ArcNode*)malloc(sizeof(ArcNode));
            e->adjvex=i;
            e->nextarc=G.adjlist[j].firstarc;
            G.adjlist[j].firstarc=e;*/
 
   
  }
}

void indu(ALGraph G)

{
      int i, j, n = 0;

      int A[G.v];

      for (i = 0; i < G.v; i++)
 
        A[i] = 0;

      ArcNode *e;

          for (j = 0; j < G.v; j++)
 
        {
            while (G.adjlist[j].firstarc != NULL)
 
        {
                  A[G.adjlist[j].firstarc->adjvex]++;

                  e = G.adjlist[j].firstarc->nextarc;

                  G.adjlist[j].firstarc = e;

             
    }

           
  }

          for (i = 0; i < G.v; i++)
 
            printf("%d ", A[i]);
}

void outdu(ALGraph G)

{
      int n = 0, i = 0;

      ArcNode *e;

      for (i = 0; i < G.v; i++)
 
    {
            while (G.adjlist[i].firstarc != NULL)
 
        {
                  n++;

                  e = G.adjlist[i].firstarc->nextarc;

                  G.adjlist[i].firstarc = e;

             
    }

            if (n == 0)
 
            num++;

            printf("%d ", n);

            n = 0;

       
  }
}

int main()

{
      ALGraph G;

      CreateALGraph(G);

      printf("出度：");

      outdu(G);

      printf("\n");

      printf("入度：");

      indu(G);

      printf("\n");

      printf("出度为0的节点数\n");

      printf("%d\n", num);

      return 0;
}