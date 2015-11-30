package command;

import receiver.IEnregistreur;
import receiver.IMoteurEdition;
import util.IMemento;

public class CollerEnreg extends Coller implements ICommandEnreg {
	private IEnregistreur enregistreur;

	public CollerEnreg(IMoteurEdition moteurEdition, IEnregistreur enregistreur)
	{
		super(moteurEdition);
		this.enregistreur = enregistreur;
	}

	@Override
	public IMemento getMemento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMemento(IMemento menento) {
		// TODO Auto-generated method stub

	}

	public void execute()
	{
		super.execute();
		this.enregistrer();
	}

	@Override
	public void enregistrer() {
		this.enregistreur.enregistrer(this);

	}

}
