/**
 * Definition for a point.
 * struct Point {
 *     int x;
 *     int y;
 *     Point() : x(0), y(0) {}
 *     Point(int a, int b) : x(a), y(b) {}
 * };
 */
class Solution {
public:
    int maxPoints(vector<Point>& points) {
        if (points.size() < 3) return points.size();

        int maxSize = 1;
        bool found;
        vector<int> value;

        int i = 0,j = 0;
        int tmp_value;
        double u;
        while(i < points.size()) {
            tmp_value = 1;
            j = i + 1;
            while (j < points.size()) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    points.erase (points.begin() + j);
                    tmp_value++;
                    continue;
                }
                j++;
            }
            value.push_back(tmp_value);
            i++;
        }

        if (points.size() == 1) {
            return value[0];
        }


        for (int i = 0; i < points.size();i++) {
            //if (i > 1) break;
            vector<Point> map;
            vector<double> map_diff;
            vector<int> map_size;
            for (int j = i + 1; j <points.size();j++) {
                found = false;
                Point poi;
                poi.x = points[i].x - points[j].x;
                poi.y = points[i].y - points[j].y;
                u = 0;
                if (poi.x == 0 && poi.y != 0) {
                    poi.y = 1;
                } else if (poi.x != 0 && poi.y == 0) {
                    poi.x = 1;
                } else if (poi.x != 0 && poi.y != 0){
                    if (poi.x < 0) {
                        poi.x = -poi.x;
                        poi.y = -poi.y;
                    }
                    u = (double)poi.x / (double)poi.y;
                    poi.x = (1000) * (u);
                    poi.y = 1;
                }
                for (int target = 0; target < map.size();target++) {
                    if (map[target].x == poi.x && map[target].y == poi.y && u == map_diff[target]) {
                        map_size[target] += value[j];
                        if (map_size[target]> maxSize) {
                            maxSize = map_size[target];
                        }
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    map.push_back(poi);
                    map_diff.push_back(u);
                    map_size.push_back(value[i] + value[j]);
                    if (value[i] + value[j] > maxSize) {
                        maxSize =value[i] + value[j];
                    }
                }
            }
        }
        return maxSize;
    }
};