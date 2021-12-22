package coordinateCalculator.domain;

public interface Figure {
   String COORDINATE_DELIMITER = "-";

   default double calculate(){
      return 0;
   }
}
