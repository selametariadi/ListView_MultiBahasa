package com.selamet.ariadi;

import android.content.Context;

import com.selamet.ariadi.model.Elang;
import com.selamet.ariadi.model.Hewan;
import com.selamet.ariadi.model.Hiu;
import com.selamet.ariadi.model.Primata;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private static List<Hewan> hewans = new ArrayList<>();

    private static List<Primata> DataPrimata(Context ctx) {
        List<Primata> Primatas = new ArrayList<>();
        Primatas.add(new Primata(ctx.getString(R.string.pri1), "Sumatra",
                ctx.getString(R.string.pen1), R.drawable.pri1));
        Primatas.add(new Primata(ctx.getString(R.string.pri2), ctx.getString(R.string.asal2),
                ctx.getString(R.string.pen2), R.drawable.pri2));
        Primatas.add(new Primata(ctx.getString(R.string.pri3), "Sulawesi",
                ctx.getString(R.string.pen3), R.drawable.pri3));
        Primatas.add(new Primata(ctx.getString(R.string.pri4), ctx.getString(R.string.asal4),
                ctx.getString(R.string.pen4), R.drawable.pri4));
        Primatas.add(new Primata(ctx.getString(R.string.pri5), ctx.getString(R.string.asal5),
                ctx.getString(R.string.pen5), R.drawable.pri5));
        return Primatas;
    }

    private static List<Elang> DataElang(Context ctx) {
        List<Elang> Elangs = new ArrayList<>();
        Elangs.add(new Elang(ctx.getString(R.string.el1), ctx.getString(R.string.as1),
                ctx.getString(R.string.penj1), R.drawable.el1));
        Elangs.add(new Elang(ctx.getString(R.string.el2), ctx.getString(R.string.as2),
                ctx.getString(R.string.penj2), R.drawable.el2));
        Elangs.add(new Elang(ctx.getString(R.string.el3), ctx.getString(R.string.as3),
                ctx.getString(R.string.penj3), R.drawable.el3));
        Elangs.add(new Elang(ctx.getString(R.string.el4), "Asia",
                ctx.getString(R.string.penj4), R.drawable.el4));
        Elangs.add(new Elang(ctx.getString(R.string.el5), ctx.getString(R.string.as5),
                ctx.getString(R.string.penj5), R.drawable.el5));
        return Elangs;
    }

    private static List<Hiu> DataHiu(Context ctx) {
        List<Hiu> Hius = new ArrayList<>();
        Hius.add(new Hiu(ctx.getString(R.string.h1), ctx.getString(R.string.fr1),
                ctx.getString(R.string.p1), R.drawable.hiu1));
        Hius.add(new Hiu(ctx.getString(R.string.h2), ctx.getString(R.string.fr2),
                ctx.getString(R.string.p2), R.drawable.hiu2));
        Hius.add(new Hiu(ctx.getString(R.string.h3), ctx.getString(R.string.fr3),
                ctx.getString(R.string.p3), R.drawable.hiu3));
        Hius.add(new Hiu(ctx.getString(R.string.h4), ctx.getString(R.string.fr4),
                ctx.getString(R.string.p4), R.drawable.hiu4));
        Hius.add(new Hiu(ctx.getString(R.string.h5), ctx.getString(R.string.fr5),
                ctx.getString(R.string.p5), R.drawable.hiu5));
        return Hius;
    }

    private static void AllHewans(Context ctx) {
        hewans.addAll(DataPrimata(ctx));
        hewans.addAll(DataElang(ctx));
        hewans.addAll(DataHiu(ctx));
    }

    public static List<Hewan> getAllHewan(Context ctx) {
        if (hewans.size() == 0) {
            AllHewans(ctx);
        }
        return  hewans;
    }

    public static List<Hewan> getHewansByTipe(Context ctx, String jenis) {
        List<Hewan> hewansByType = new ArrayList<>();
        if (hewans.size() == 0) {
            AllHewans(ctx);
        }
        for (Hewan h : hewans) {
            if (h.getJenis().equals(jenis)) {
                hewansByType.add(h);
            }
        }
        return hewansByType;
    }

}
