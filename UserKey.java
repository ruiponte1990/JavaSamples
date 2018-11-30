import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * @author ruiponte
 *	Implementation of UserKey based on a String and a String userid.
 *	Made suitable for HttpSession by implementing Serializable and overriding equals() and hashcode()
 */

public class UserKey implements Serializable {
	
	private String name;
	private String userid;

	public UserKey(String name, String userid) {
		this.name = name;
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public String getUserID() {
		return userid;
	}
	
	public boolean equals(Object UK) {
		if (UK == this) {
			return true;
		}
		if (!(UK instanceof UserKey)) {
            return false;
        }
		UserKey U_K = (UserKey) UK;
		return this.hashCode() == U_K.hashCode();
	}
	@Override
    public int hashCode() {
        return Objects.hash(this.name, this.userid);
    }

}


//then it should override hashCode() and equals() properly, and it would be a good idea to make it immutable.




