package com.nepjr.client.gui;

import com.nepjr.container.ContainerMachineBase;
import com.nepjr.te.TileEntityGeneratorBase;

public abstract class GuiMachineBase<T extends TileEntityGeneratorBase, C extends ContainerMachineBase<T>> extends AnimationCrap {

    protected final T machineTile;
    protected final C container;

    public GuiMachineBase(C container) {
        super(container);
        this.container = container;
        machineTile = container.getTile();
    }

    protected static float scaleF(float num, float max, float pixels) {
        return num * pixels / max;
    }

    protected static int scale(int num, int max, int pixels) {
        return num * pixels / max;
    }
}
