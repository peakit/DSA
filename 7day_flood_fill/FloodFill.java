public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if(originalColor == newColor) {
            return image;
        }

        fillDFS(image, sr, sc, originalColor, newColor);
        return image;
    }

    private void fillDFS(int[][] image, int rowIdx, int colIdx, int originalColor, int newColor) {
        if (rowIdx > image.length - 1 || rowIdx < 0 || colIdx > image[0].length - 1 || colIdx < 0
                || image[rowIdx][colIdx] != originalColor) {
            return;
        }

        if (image[rowIdx][colIdx] == originalColor) {
            image[rowIdx][colIdx] = newColor;

            fillDFS(image, rowIdx, colIdx - 1, originalColor, newColor);
            fillDFS(image, rowIdx, colIdx + 1, originalColor, newColor);
            fillDFS(image, rowIdx - 1, colIdx, originalColor, newColor);
            fillDFS(image, rowIdx + 1, colIdx, originalColor, newColor);
        }
    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        // int[][] image = {
        // { 1, 1, 1, 1, 1, 1 },
        // { 1, 1, 1, 1, 1, 1 },
        // { 1, 1, 1, 1, 1, 1 }
        // };
        int[][] image = {
                { 0, 0, 0 },
                { 0, 1, 1 }
        };
        floodFill.floodFill(image, 1, 1, 1);
    }
}
