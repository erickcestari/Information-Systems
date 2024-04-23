abstract class Produto {
    protected String id;

    public Produto() {
    }

    public Produto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
