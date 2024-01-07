package net.swimmingtuna.lotm.Beyonder.BeyonderStats.BeyonderSpirituality;

import net.minecraft.nbt.CompoundTag;

public class BeyonderSpirituality {
        private int spirituality;
        private final int MAX_SPIRITUALITY =  100;
        private final int MIN_SPIRUALITY = 0;

        public int getSpiruality() {
            return spirituality;}

        public void addSpirituality(int add) {
            this.spirituality= Math.min(spirituality + add, MAX_SPIRITUALITY);}

        public void subSpirituality(int sub) {
            this.spirituality = Math.max(spirituality - sub, MIN_SPIRUALITY);
        }

        public void copyFrom(BeyonderSpirituality source) {
            this.spirituality = source.spirituality;
        }

        public void saveNBTData(CompoundTag nbt)
        {
            nbt.putInt("spirituality", spirituality);
        }

        public void loadNBTData (CompoundTag nbt)
        {
            spirituality = nbt.getInt("thirst");
        }
    }

