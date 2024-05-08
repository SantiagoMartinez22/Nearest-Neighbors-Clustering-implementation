import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.PriorityQueue;
import java.util.*;


public class Clustering {
    private Punto2D[] puntos;
    private UnionFind uf;



    public Clustering(Punto2D[] puntos) {
        this.puntos = puntos;
        this.uf = new UnionFind(puntos.length);

    }

    public int clasificar(Punto2D p, int k) {
        PriorityQueue<Punto2D> maxHeap = new PriorityQueue<>(k, (a, b) -> Double.compare(p.distanciaA(b), p.distanciaA(a)));

        for (int i = 0; i < puntos.length; i++) {
            double distancia = p.distanciaA(puntos[i]);
            if (maxHeap.size() < k) {
                maxHeap.offer(puntos[i]);
            } else if (distancia < p.distanciaA(maxHeap.peek())) {
                maxHeap.poll();
                maxHeap.offer(puntos[i]);
            }
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        while (!maxHeap.isEmpty()) {
            Punto2D pt = maxHeap.poll();
            int clusterIdx = uf.find(java.util.Arrays.asList(this.puntos).indexOf(pt));
            frequency.put(clusterIdx, frequency.getOrDefault(clusterIdx, 0) + 1);
        }

        return Collections.max(frequency.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public int clusterizar(Punto2D[] puntos, double dMax) {
        PriorityQueue<DistanciaPunto> pq = new PriorityQueue<>((a, b) -> Double.compare(a.distancia, b.distancia));

        for (int i = 0; i < this.puntos.length; i++) {
            for (int j = i + 1; j < this.puntos.length; j++) {
                double distancia = this.puntos[i].distanciaA(this.puntos[j]);
                pq.add(new DistanciaPunto(i, j, distancia));
            }
        }

        while (!pq.isEmpty()) {
            DistanciaPunto dp = pq.poll();
            if (dp.distancia > dMax) break;
            uf.union(dp.indexP1, dp.indexP2);
        }

        return uf.getCount();
    }

    private static class DistanciaPunto {
        int indexP1;
        int indexP2;
        double distancia;

        public DistanciaPunto(int indexP1, int indexP2, double distancia) {
            this.indexP1 = indexP1;
            this.indexP2 = indexP2;
            this.distancia = distancia;
        }
    }



    public void randomTest() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            Punto2D randomPoint = new Punto2D(rand.nextDouble() * 100, rand.nextDouble() * 100);
            int cluster = clasificar(randomPoint, 5); // asumiendo que queremos los 5 vecinos más cercanos asi que k=5
            System.out.println("Punto " + randomPoint + " pertenece al clúster " + cluster);
        }
    }
    public int getClusterCount() {
        return uf.getCount();
    }

    public void graficarClusteres() {
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(-2, 2);
        StdDraw.setYscale(-2, 2);

        HashMap<Integer, Color> clusterColors = new HashMap<>();
        Random rand = new Random();

        for (int i = 0; i < puntos.length; i++) {
            int clusterIdx = uf.find(i);
            if (!clusterColors.containsKey(clusterIdx)) {
                clusterColors.put(clusterIdx, new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
            }
            StdDraw.setPenColor(clusterColors.get(clusterIdx));
            StdDraw.filledCircle(puntos[i].getX(), puntos[i].getY(), 0.05);
        }
    }



}

