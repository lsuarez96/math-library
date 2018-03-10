package UnidimencionalOptimizacion;

public class AuxSequentialAndUniformResult{
	private int iteration;
	private double methodValue;
	private double research;
	
	public AuxSequentialAndUniformResult(int iteration, double methodValue,
			double research) {
		super();
		this.iteration = iteration;
		this.methodValue = methodValue;
		this.research = research;
	}

	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	public double getMethodValue() {
		return methodValue;
	}

	public void setMethodValue(double methodValue) {
		this.methodValue = methodValue;
	}

	public double getResearch() {
		return research;
	}

	public void setResearch(double research) {
		this.research = research;
	}
	
	   public String toString() {
	        return "Iter: " + String.valueOf(iteration) + "Research: " + String.valueOf(research) + "Method Value: " + String.valueOf(methodValue) + "\n";
	    }
}
