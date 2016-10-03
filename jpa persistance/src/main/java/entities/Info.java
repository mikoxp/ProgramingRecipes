package entities;

import javax.persistence.*;

/**
 * Created by moles on 03.10.2016.
 */
@Entity
@Table(name = "info")
@SequenceGenerator(name = "info_seq", sequenceName = "info_id_seq")
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "info_seq")
    private int id;
    @Column(name = "info", length = 64)
    private String info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Info info1 = (Info) o;

        if (id != info1.id) return false;
        return info != null ? info.equals(info1.info) : info1.info == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}
