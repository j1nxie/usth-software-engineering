package tutorial_01;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

public class MobilePhone {
	enum Color {
		Red,
		Orange,
		Yellow,
		Blue,
		Purple,
	}

	@DomainConstraint(type = "String", mutable = false, optional = false, length = 100)
	private String manName;

	@DomainConstraint(type = "String", mutable = false, optional = false, length = 50)
	private String model;

	@DomainConstraint(type = "Color", mutable = true, optional = false)
	private Color color;

	@DomainConstraint(type = "int", mutable = false, optional = false)
	private int year;

	@DomainConstraint(type = "boolean", mutable = false, optional = false)
	private boolean guaranteed;

	@DOpt(type = OptType.Observer)
	@AttrRef("manName")
	public String getManName() {
		return manName;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("model")
	public String getModel() {
		return model;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("color")
	public Color getColor() {
		return color;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("year")
	public int getYear() {
		return year;
	}

	@DOpt(type = OptType.Observer)
	@AttrRef("guaranteed")
	public boolean getGuaranteed() {
		return guaranteed;
	}

	public MobilePhone(@AttrRef("manName") String manName, @AttrRef("model") String model,
			@AttrRef("color") Color color,
			@AttrRef("year") int year, @AttrRef("guaranteed") boolean guaranteed) throws NotPossibleException {
		if (!validateManName(manName)) {
			throw new NotPossibleException("invalid manName: " + manName);
		}

		if (!validateModel(model)) {
			throw new NotPossibleException("invalid model: " + model);
		}

		if (!validateColor(color)) {
			throw new NotPossibleException("invalid color: " + color);
		}

		this.manName = manName;
		this.model = model;
		this.color = color;
		this.year = year;
		this.guaranteed = guaranteed;
	}

	public void setColor(Color color) throws NotPossibleException {
		if (!validateColor(color)) {
			throw new NotPossibleException("invalid color: " + color);
		}

		this.color = color;
	}

	private boolean validateManName(String manName) {
		if (manName == null || manName.length() == 0 || manName.length() > 100) {
			return false;
		}

		return true;
	}

	private boolean validateModel(String model) {
		if (model == null || model.length() == 0 || model.length() > 50 || !model.matches("^M-[A-Z]{3}-[0-9]{3}$")) {
			return false;
		}

		return true;
	}

	private boolean validateColor(Color color) {
		for (Color vc : Color.values()) {
			if (color == vc) {
				return true;
			}
		}

		return false;
	}
}
