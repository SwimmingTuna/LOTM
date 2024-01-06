package net.swimmingtuna.lotm.BeyonderStats.BeyonderSpirituality;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BeyonderSpiritualityProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    public static Capability<BeyonderSpirituality> BEYONDER_SPIRITUALITY = CapabilityManager.get(new CapabilityToken<BeyonderSpirituality>() {});

    private BeyonderSpirituality spirituality = null;
    private final LazyOptional<BeyonderSpirituality> optional = LazyOptional.of(this::createBeyonderSpirituality);

    private BeyonderSpirituality createBeyonderSpirituality() {
        if (this.spirituality == null) {
            this.spirituality = new BeyonderSpirituality();
        }
        return this.spirituality;

    }


    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap== BEYONDER_SPIRITUALITY) {
            return optional.cast();
        }
        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createBeyonderSpirituality().saveNBTData(nbt);
        return null;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
createBeyonderSpirituality().loadNBTData(nbt);
    }
}