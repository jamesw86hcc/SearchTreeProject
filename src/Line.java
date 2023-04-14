public class Line {

    private int number;
    private String content;

    public Line(){
        number = 0;
        content = "";
    }

    public Line(int n, String text){
        number = n;
        content = text;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }
}
