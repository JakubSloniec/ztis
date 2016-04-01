package pl.edu.agh.ztis.entity;

/**
 * Created by kkicinger on 01/04/16.
 */
public enum Magazine {

    JORMEX,
    NACION,
    CHRONI,
    GUARDI,
    NYTIME,
    TMALTA,
    LARAZO,
    DERHEU,
    MOPOST,
    UNIVER,
    DAILYT,
    THIDAY,
    ELWATA,
    LMONDE,
    HINDTI,
    MERCUR,
    TWODAY,
    NZHERA,
    AUSTRA,
    CATALU,
    JATIME,
    HERSUN,
    PATRIA,
    TINDIA,
    LESOIR,
    XPRESS,
    LEPARI,
    STARMY,
    NEWINT,
    JMONTR,
    WAPOST,
    CHINAD,
    TERCER,
    STARCA,
    ELPAIS;

    public static Magazine get(final String lowerCaseMagazineName) {
        return Magazine.valueOf(lowerCaseMagazineName.toUpperCase());
    }

}
