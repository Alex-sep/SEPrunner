package gameObject.player;

import gameObject.enemy.Enemy;
import gameObject.statics.HookAnchor;

public interface Reactable {

	public void hide();
	public void unhide();
	
	public void hook(HookAnchor anchor);
	
	public void carry(Enemy enemy);
	public void dispose(Enemy enemy);
	
}
