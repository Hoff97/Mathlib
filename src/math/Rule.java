package math;

import java.util.ArrayList;

import math.types.Variable;
import ntuple.Tuple;

/**
 * Eine beliebige mathematische Regel, die auf einen Therm angewendet werden kann.
 * @author Frithjof
 * @version 1.0
 * @created 31-Aug-2014 21:45:59
 */
public abstract class Rule {

	/**
	 * Wendet die Regel auf die Struktur an.
	 * 
	 * @param countable    Die Struktur, auf die die Regel angewendet wird.
	 */
	public Countable apply(Countable countable) throws NotApplyable{
		try {
			return applySingle(countable);
		} catch (Exception e) {
			if(countable instanceof NonLeaf) {
				NonLeaf d = (NonLeaf)countable;
				for(int i = 0; i<d.subTherms.size(); i++) {
					try {
						Countable s = this.apply(d.subTherms.get(i));
						ArrayList<Countable> subs = new ArrayList<Countable>();
						for(int j = 0; j<d.subTherms.size(); j++) {
							if(i!=j) {
								subs.add(d.subTherms.get(j).clone());
							} else 
								subs.add(s);
						}
						return d.create(subs);
						
					} catch(Exception e2) {}
				}
			}
			
			throw new NotApplyable();
		}
	}
	
	
	public abstract Countable applySingle(Countable countable) throws NotApplyable;
}