from heapq import heappop, heappush
from typing import List


class Solution:
    def getSkyline(self, buildings: List[List[int]]) -> List[List[int]]:
        res =[]
        edges = []
        buildings = sorted(buildings, key = lambda x: x[2], reverse = True)
        for i, building in enumerate(buildings):
            l ,r, h = building
            edges.append((l, 0, i))
            edges.append((r, 1, i))
        edges = sorted(edges, key = lambda x: (x[0], x[1], x[2]))
        pq = []
        prevTop = 0
        for edge in edges:
            cur, isLeft, buildingNo = edge
            while len(pq) > 0 and pq[0][1]<= cur:
                heappop(pq)
            building = buildings[buildingNo]
            l, r, h = building
            if isLeft == 0:
                heappush(pq, (-h, r))
            curTop = pq[0][0] if len(pq) > 0 else 0
            if curTop != prevTop:
                res.append([cur, -curTop])
                prevTop = curTop
        return res