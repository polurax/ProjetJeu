package metier;

public class Vecteur {
	private double x;
	private double y;

	public Vecteur(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vecteur(char orientation) {
		switch (orientation) {
		case 'H':
			x = 0;
			y = -1;
			break;
		case 'B':
			x = 0;
			y = 1;
			break;
		case 'G':
			x = -1;
			y = 0;
			break;
		default:
			x = 1;
			y = 0;
			break;
		}
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public char getOrientation() {
		
		if (this.x > 0.5) {
			return 'D';
		} else if (this.x <-0.5) {
			return 'G';
		} else if (this.y > 0.5) {
			return 'B';
		} else if (this.y < -0.5) {
			return 'H';
		} else {
			return '!';
		}
	}
}
