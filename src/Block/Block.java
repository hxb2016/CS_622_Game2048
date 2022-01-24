
package Block;
import java.io.Serializable;
/**
 * Purpose of this class is creat a Block Object
 */
public class Block implements Serializable {
    public static final long serialVersionUID = 1L;
    public int number = 0;
    public int[] location = null;
    public boolean ifCombine = false;

    public Block(int number, int[] location) {
        this.number = number;
        this.location = location;
    }

    public Block() {
    }


}
