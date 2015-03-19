package math;

import ntuple.*;
import java.util.ArrayList;
import math.types.*;

/**
 * Grundlegendes Interface für alle mathematischen Strukturen
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:56
 */
public interface Countable {

	/**
	 * Dupliziert das Objekt.
	 */
	public abstract Countable clone();

	/**
	 * Gibt an, ob ein Subtherm in diesem Therm enthalten ist.
	 * 
	 * @param countable    Der Subtherm, nach dem gesucht wird.
	 */
	public boolean contains(Countable countable);

	/**
	 * Substituiert alle Subtherme gleich der linken Seite der Gleichung durch die
	 * Rechte.
	 * 
	 * @param equation    Die Gleichung, die angibt welcher Therm durch welchen zu
	 * substituieren ist.
	 */
	public Countable substitute(Equation equation);
	
	
	/**
	 * Vergleicht eine Struktur mit einer anderen und gibt, wenn möglich alle Bindungen
	 * von Variablen, die so entstehen, zurück
	 * 
	 * @param oth   Die Struktur mit der verglichen wird
	 */
	public ArrayList<Tuple<Variable,Countable>> match(Countable oth) throws NotMatchable;
	
	public String toString();
	
	public boolean equals(Countable c);
}