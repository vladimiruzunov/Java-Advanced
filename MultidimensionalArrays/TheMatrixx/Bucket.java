package TheMatrixx;

public class Bucket {
    private int row;
    private int col;

    private char colorToReplace;
    private Matrix matrix;

    public Bucket(int row, int col, Matrix matrix) {
        this.row = row;
        this.col = col;
        this.colorToReplace = matrix.getCell(row,col);
        this.matrix = matrix;
    }

    public void paint(char fillColor){

        paint(row, col, colorToReplace, fillColor, matrix);
    }
    public void paint(int row, int col, char colorToReplace, char fillColor, Matrix matrix){

        if (matrix.isOutOfBounds(row, col)
                || matrix.getCell(row, col) != colorToReplace
        || matrix.getCell(row, col) == fillColor){
            return;
        }
        matrix.setCell(row, col, fillColor);

        paint(row -1, col, colorToReplace, fillColor, matrix);
        paint(row +1, col, colorToReplace, fillColor, matrix);
        paint(row, col - 1, colorToReplace, fillColor, matrix);
        paint(row, col + 1, colorToReplace, fillColor, matrix);


    }
}