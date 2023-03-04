#include <iostream>
#include <bits/stdc++.h>

using namespace std;
int n, m, i, j, c_num = 1;
vector <int> comp(n,0);
vector <bool> used(n, false);
vector <vector <pair<int, int>>> graph(n);

void dfs(int v, int c_num) {
    used[v] = true;
    comp[v] = c_num;

    for (int i = 0; i < graph[v].size(); i++) {
        if (!used[graph[v][i].second]) {
            dfs(graph[v][i].second, c_num);
        }
    }
}

int main() {
    for (int i = 0; i < m; i++) {
        cin>>i>>j;
        graph[i-1].push_back(pair(i-1, j-1));
    }
    for (int i = 0; i < n; i++) {
        if (!used[i]) {
            dfs(i, c_num);
        }
    }
    int flag = 0;
    for (int i = 1; i < *max_element(comp.begin(),comp.end()); i++) {
        int num_comp = 0, num_edges = 0;
        for (int j = 0; j < comp.size(); j++) {
            if (comp[j] == i) {
                num_comp += 1;
                num_edges += graph[j].size();
            }
        }
        if (num_comp != num_edges) {
            flag = 1;
            break;
        }
    }
    if (flag == 1)
        cout<<"No";
    else
        cout<<"Yes";


    return 0;
}
