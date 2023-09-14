package orchard.utils;

public enum FXMLPath {
	MAINPAGE("/orchard/gui/scenes/mainPage.fxml"),
	GAMESCENE("/orchard/gui/scenes/gameScene.fxml"),
	WINNESCENE("/orchard/gui/scenes/winneScene.fxml"),
	CROWSCENE("/orchard/gui/scenes/CrowScene.fxml");
	

	private final String path;
	
	FXMLPath(String path) {
		this.path = path;
	}

	public String path() {
		return path;
	}
	
	
}
	