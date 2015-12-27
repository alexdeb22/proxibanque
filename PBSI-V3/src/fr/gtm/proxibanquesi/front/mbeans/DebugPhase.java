package fr.gtm.proxibanquesi.front.mbeans;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/** Phase listener utilisé pour suivre les différentes phases du traitement de requêtes JSF.
 * @author Alex
 *
 */
public class DebugPhase implements PhaseListener {

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent phase) {
		System.out.println("Fin de phase " + phase.getPhaseId());

	}

	@Override
	public void beforePhase(PhaseEvent phase) {
		System.out.println("Début de phase " + phase.getPhaseId());

	}

	@Override
	public PhaseId getPhaseId() {
		
		return PhaseId.ANY_PHASE;
	}

}
