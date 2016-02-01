
/**
 *  Die.java       Java Foundations
 * 
 *  @author Java Foundations
 */

public class Die
{
   private final int MAX = 6;  // maximum face value

   private int faceValue;  // current value showing on the die

   /**
    *  Constructor: Sets the initial face value of this die.
    */
   public Die()
   {
      faceValue = 1;
   }

   /**
    *  Computes a new face value for this die and returns the result.
    */
   public void roll()
   {
      faceValue = (int)(Math.random() * MAX) + 1;
   }

   /**
    * Face value mutator. The face value is not modified if the
    *  specified value is not valid.
    *
    *  @param value
    */
   public void setFaceValue (int value)
   {
      if (value > 0 && value <= MAX)
         faceValue = value;
   }

   /**
    *  Face value accessor.
    */
   public int getFaceValue()
   {
      return faceValue;
   }

   /**
    *  Returns a string representation of this die.
    */
   public String toString()
   {
      String result = Integer.toString(faceValue);

      return result;
   }
}