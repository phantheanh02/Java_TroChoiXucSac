 /*  
  * Họ và tên: Phan Thế Anh
  * MSSV: 20204941
 */
package model;

public class Player {
    private String name;
    private int point;

    public Player(String name) {
        this.name = name;
        this.point = 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
