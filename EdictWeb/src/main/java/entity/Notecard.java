package entity;

public class Notecard {
    private int id;
    private String name;
    private String def;
    private String note;
    private String img;
    private int book_id;
    private int hit;
    private int author_id;

    @Override
    public String toString() {
        return "Notecard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", def='" + def + '\'' +
                ", note='" + note + '\'' +
                ", img='" + img + '\'' +
                ", book_id=" + book_id +
                ", hit=" + hit +
                ", author_id=" + author_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
}
