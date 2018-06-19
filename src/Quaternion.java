public class Quaternion {
    float s;    //Scalar Component
    Vector3 v; //Vector Component

    //Constructors
    public Quaternion(){
        s=0;
        v= new Vector3();
    }
    public Quaternion(float scalar,Vector3 vector){
        s=scalar;
        v=new Vector3(vector);
    }
    //Copy constructor
    public Quaternion(Quaternion q){
        s=q.s;
        v=new Vector3(q.v);
    }
    //Basic Arithmetic functions
    public Quaternion add(Quaternion q){
        float resultScalar = s+q.s;
        Vector3 resultVector = v.add(q.v);
        return  new Quaternion(resultScalar,resultVector);
    }
    public Quaternion subtract(Quaternion q){
        float resultScalar = s-q.s;
        Vector3 resultVector = v.subtract(q.v);
        return  new Quaternion(resultScalar,resultVector);
    }
    //Multiply function
    //You can either multiply by a scalar or another Quaternion
    public  Quaternion multiplyBy(Quaternion q){
        float resultScalar=(s*q.s)-v.dot(q.v);
        Vector3 resultVector = ((q.v.multiplyBy(s)).add(v.multiplyBy(q.s))).add(v.cross(q.v));
        return new Quaternion(resultScalar,resultVector);
    }
    public  Quaternion multiplyBy(float scalar){
        float resultScalar = s*scalar;
        Vector3 resultVector = v.multiplyBy(scalar);
        return new Quaternion(resultScalar,resultVector);
    }
    //A function to get the norm of the Quaternion
    //Norm is similar to magnitude in Vectors
    public float getNorm(){
        return (float) Math.sqrt(s*s+(v.getMagnitude()*v.getMagnitude()));
    }
    //A function to get the unit Norm of the Quaternion
    // Unit norm is similar to unit vector in Vector
    public Quaternion getUnitNorm(){
        return this.multiplyBy(1/this.getNorm());
    }
    //A function to get the conjugate of the Quaternion
    // Conjugate of a quaternion is just opposite in direction
    public Quaternion getConjugate(){
        return  new Quaternion(this.s,this.v.multiplyBy(-1));
    }
    //A function that returns the Inverse of the Quaternion
    public Quaternion getInverse(){
        Quaternion c=getConjugate();
        float multiplicant=1/(getNorm()*getNorm());
        return c.multiplyBy(multiplicant);
    }

}