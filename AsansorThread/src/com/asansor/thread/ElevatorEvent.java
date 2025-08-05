package com.asansor.thread;

public class ElevatorEvent
{
	private int hedef;
	private int beklenen_varis;
	
	public ElevatorEvent()
	{
		this.hedef = 0;
		this.beklenen_varis = 0;
	}

	public ElevatorEvent(int hedef, int beklenen_varis)
	{
		this.hedef = hedef;
		this.beklenen_varis = beklenen_varis;
	}

	public int hedefi_al()
	{
		return hedef;
	}

	public int tahminivarisi_al()
	{
		return beklenen_varis;
	}
}