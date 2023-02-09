package entity;

public class Notebook {
    private int id;
    private String name;
    private int author_id;
    private String update;
    private long updatetime;

    private int wordscount;

    @Override
    public String toString() {
        return "Notebook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author_id=" + author_id +
                ", update='" + update + '\'' +
                ", updatetime=" + updatetime +
                ", wordscount=" + wordscount +
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

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getWordscount() {
        return wordscount;
    }

    public void setWordscount(int wordscount) {
        this.wordscount = wordscount;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(long updatetime) {
        this.updatetime = updatetime;
    }
}
