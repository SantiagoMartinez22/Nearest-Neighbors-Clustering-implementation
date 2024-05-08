
# Nearest Neighbors Clustering

This repository provides a Java implementation of the nearest neighbors clustering algorithm for two-dimensional data. Nearest neighbors clustering is a data clustering method that aims to identify groups of "similar" points in a 2D space.

## Algorithm Description

The algorithm follows an efficient process for grouping points into meaningful clusters Using DSA:

1. **Cluster Initialization**: Each point in the dataset is initially considered as an individual cluster.

2. **Distance Calculation and Prioritization**: The distance between each pair of points in the dataset is calculated and prioritized using a minimum priority queue (MinPQ).

3. **Cluster Union**: Points are processed in order of distance, and they are merged into larger clusters if the distance between them is less than a configurable maximum threshold.

4. **Process Completion**: Once there are no points left with a distance less than the maximum threshold, the clustering process concludes. The number of clusters obtained and the total operation time are reported.

## Applicability in Computer Science

The nearest neighbors clustering algorithm has wide applicability in various areas of computer science, including:

- **Data Mining**: It is used to discover hidden patterns and structures in large datasets, facilitating informed decision-making in areas such as marketing, medicine, and scientific research.

- **Machine Learning**: It is employed in unsupervised learning techniques to segment data and facilitate analysis and interpretation.

- **Pattern Recognition**: It helps identify groups or clusters in images, text, and other types of data, which is crucial in applications such as computer vision and natural language processing.

- **Computational Biology**: It is used to analyze biological data, such as genetic sequences or protein structures, to better understand the function and relationship between different biological elements.

## Implemented Functionalities

- **Clustering Class**: Contains the `clusterize` method, which takes an array of 2D points as input and returns the number of clusters obtained.

- **Function to Read Points from a CSV File**: The `readPoints` function allows loading points from a .csv file and returning them as a 2D point array.

- **Method for Classifying New Points**: The `classify` method allows classifying new points by finding the `k` nearest neighbors and assigning the most repeated connected component number among them.

- **Random Point Generation and Classification**: The `randomTest` method generates 10 random points, classifies them, and reports which cluster each point belongs to.

- **Cluster Visualization**: The `visualizeClusters` method visualizes the points of each cluster, assigning a different color to the points of each cluster.

## Usage

To use this implementation run the Main class and into the Main class introduce the path of your CSV file with the points, or enter the path of the Csv files included in the repo

## Requirements

- Java JDK
- StdDraw library (for cluster visualization)
- algs4 princeton library for the Data Structure implementation


