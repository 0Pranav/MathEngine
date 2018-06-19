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
    public Quaternion(Quaternion q){
        s=q.s;
        v=new Vector3(q.v);
    }
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
    public float getNorm(){
        return (float) Math.sqrt(s*s+(v.getMagnitude()*v.getMagnitude()));
    }
    public Quaternion getUnitNorm(){
        return this.multiplyBy(1/this.getNorm());
    }
    public Quaternion getConjugate(){
        return  new Quaternion(this.s,this.v.multiplyBy(-1));
    }
    public Quaternion getInverse(){
        Quaternion c=getConjugate();
        float multiplicant=1/(getNorm()*getNorm());
        return c.multiplyBy(multiplicant);
    }

}