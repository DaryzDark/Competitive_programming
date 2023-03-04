#include <iostream>
#include <vector>

using namespace std;
int main() {
    int n, q, event, player_number;
    cin>>n>>q;
    vector <int> player_status(n, 0);
    for (int i=0; i < q; i++) {
        cin>>event>>player_number;
        if (event != 3) {
            player_status[player_number-1] += event;
        } else {
            if (event == 3 && player_status[player_number - 1] >= 2) {
                cout<<"Yes"<<endl;
            } else
                cout<<"No"<<endl;
        }
    }
    return 0;
}
