import java.util.Date;

public class Photo implements Comparable<Photo> {
    Integer id;
    String city;
    String photoName;
    Date timeTaken;

    public Photo(Integer id, String city, String photoName, Date timeTaken) {
        this.id = id;
        this.city = city;
        this.photoName = photoName;
        this.timeTaken = timeTaken;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((photoName == null) ? 0 : photoName.hashCode());
        result = prime * result + ((timeTaken == null) ? 0 : timeTaken.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Photo other = (Photo) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (photoName == null) {
            if (other.photoName != null)
                return false;
        } else if (!photoName.equals(other.photoName))
            return false;
        if (timeTaken == null) {
            if (other.timeTaken != null)
                return false;
        } else if (!timeTaken.equals(other.timeTaken))
            return false;
        return true;
    }

    @Override
    public int compareTo(Photo obj) {
        if (this.timeTaken.after(obj.timeTaken)) {
            return 1;
        } else if (this.timeTaken.before(obj.timeTaken)) {
            return -1;
        }
        return 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Date getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Date timeTaken) {
        this.timeTaken = timeTaken;
    }

}
