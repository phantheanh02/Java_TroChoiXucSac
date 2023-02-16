 /*  
  * Họ và tên: Phan Thế Anh
  * MSSV: 20204941
 */
package model;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        super(name);
    }

    private static String emotion[] = {
			"Thua roi",
			"Ban gioi qua",
			"Ban that xuat sac",
	};
    
    public String getEmotion() {
        int index = new Random().nextInt(emotion.length);
        return emotion[index];
    }
}
