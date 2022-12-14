package model;

public class Quiz {
    private String r1;
    private String r2;
    private String r3;
    private String r4;
    private int usuarioId;

    public Quiz(String r1, String r2, String r3, String r4, int usuarioId) {
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
        this.usuarioId = usuarioId;
    }
    
	public String getR1() {
		return r1;
	}

	public void setR1(String r1) {
		this.r1 = r1;
	}

	public String getR2() {
		return r2;
	}

	public void setR2(String r2) {
		this.r2 = r2;
	}

	public String getR3() {
		return r3;
	}

	public void setR3(String r3) {
		this.r3 = r3;
	}

	public String getR4() {
		return r4;
	}

	public void setR4(String r4) {
		this.r4 = r4;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	@Override
	public String toString() {
		return "Quiz [r1=" + r1 + ", r2=" + r2 + ", r3=" + r3 + ", r4=" + r4 + ", usuarioId=" + usuarioId
				+ "]";
	}
}