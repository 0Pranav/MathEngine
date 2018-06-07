import java.util.Vector;
public class Vector3 {
    float x;
    float y;
    float z;

    private float magnitude;
    private float direction;
    //Getter for magnitude
    public float getMagnitude() {
        return magnitude;
    }
    //Standard constructor, takes three integer values
    public Vector3(float xi, float yi, float zi){
        x=xi;
        y=yi;
        z=zi;
        magnitude=(float)Math.sqrt(x*x+y*y+z*z);
    }
    //Default constructor, returns a zero vector
    public Vector3(){
        x=0;
        y=0;
        z=0;
    }
    //Duplicator, takes a vector3
    public Vector3(Vector3 obj){
        x= obj.x;
        y= obj.y;
        z= obj.z;
    }
    //Arithmatic Operations
    public Vector3 subtract(Vector3 sub){
        float result_x=x-sub.x;
        float result_y=y-sub.y;
        float result_z=z-sub.z;
        return  new Vector3(result_x,result_y,result_z);
    }
    public Vector3 add(Vector3 add){
        float result_x=x+add.x;
        float result_y=y+add.y;
        float result_z=z+add.z;
        return  new Vector3(result_x,result_y,result_z);
    }
    public Vector3 dot(Vector3 dot){
        float result_x=x*dot.x;
        float result_y=y*dot.y;
        float result_z=z*dot.z;
        return  new Vector3(result_x,result_y,result_z);
    }
    public Vector3 multiplyBy(float scalar){
        float result_x=scalar*x;
        float result_y=scalar*y;
        float result_z=scalar*z;
        return new Vector3(x,y,z);

    }
    //Vector cross product
    public Vector3 cross(Vector3 cross){
        //Calculating Determinant of the two vectors
        float result_x= cross.z*y-cross.y*z;
        float result_y= -(cross.z*x-cross.x*z);
        float result_z=cross.y*x-cross.x*y;
        return  new Vector3(result_x,result_y,result_z);
    }
    //Unit vector along the given vector
    public Vector3 unitVector(){
        return new Vector3(x/magnitude,y/magnitude,z/magnitude);
    }
    //to Print the vector properly
    public String toString(){
        String output=x+"i";

        if(y<0)
            output=output+"-"+(y/-1)+"j";
        else
            output=output+"+"+y+"j";
        if(z<0)
            output=output+"-"+(z/-1)+"k";
        else
            output=output+"+"+z+"k";
        return output;
    }
}
