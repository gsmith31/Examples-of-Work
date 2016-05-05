package edu.elon.nutrigen.business;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Reads data from testexercise table
 * 
 * @author dpowell2
 */
public class Exercise implements Serializable {
	private Timestamp exerciselastupdatedDisp;
	private int intexercise;
	private int modexercise;
	
	public Exercise() {
		//intentionally empty
	}

	public Timestamp getExerciselastupdatedDisp() {
		return exerciselastupdatedDisp;
	}

	public void setExerciselastupdatedDisp(Timestamp exerciselastupdatedDisp) {
		this.exerciselastupdatedDisp = exerciselastupdatedDisp;
	}

	public int getIntexercise() {
		return intexercise;
	}

	public void setIntexercise(int intexercise) {
		this.intexercise = intexercise;
	}

	public int getModexercise() {
		return modexercise;
	}

	public void setModexercise(int modexercise) {
		this.modexercise = modexercise;
	}

	@Override
	public String toString() {
		return "Exercise [exerciselastupdatedDisp=" + exerciselastupdatedDisp
				+ ", intexercise=" + intexercise + ", modexercise="
				+ modexercise + "]";
	}

}
