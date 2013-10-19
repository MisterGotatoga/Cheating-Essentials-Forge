package common.kodehawa.ce.module.classes;

import net.minecraft.entity.Entity;

import common.kodehawa.ce.module.core.AbstractModule;
import common.kodehawa.ce.module.enums.Category;
import common.kodehawa.ce.reflect.ReflectionHelper;

public class Step extends AbstractModule {

	public Step() {
		super(Category.WORLD);
		this.setTick(true);
	}
	
	@Override
	public String getModuleName(){
		return "Step";
	}

	@Override
	public void tick(){
		Object o = getPlayer();
		ReflectionHelper.setField(Entity.class, o, 42, 1.0F);
	}
}
