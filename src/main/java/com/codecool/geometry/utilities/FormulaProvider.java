package com.codecool.geometry.utilities;

public class FormulaProvider {

    /**
     * Returns the area formula of a given shape
     * @param shape type of the shape of the requested formula
     * @return area formula as String
     */
    public static String getAreaFormulaForShape(String shape) {
        String areaFormula;

        switch (shape) {
            case "Circle":
                areaFormula = "π×r×r";
                break;
            case "Rectangle":
                areaFormula = "a×b";
                break;
            case "Triangle":
                areaFormula = "sqrt(s×(s-a)×(s-b)×(s-c))";
                break;
            case "Square":
                areaFormula = "a×a";
                break;
            case "EquilateralTriangle":
                areaFormula = "a×a×sqrt(3)/4";
                break;
            case "RegularPentagon":
                areaFormula = "a×a×sqrt(5×(5+2×sqrt(5))/4";
                break;
            default:
                areaFormula = "No area formula.";
        }
        return areaFormula;
    }

    /**
     * Returns the perimeter formula of a given shape
     * @param shape type of the shape of the requested formula
     * @return perimeter formula as String
     */
    public static String getPerimeterFormulaForShape(String shape) {
        String perimeterFormula;

        switch (shape) {
            case "Circle":
                perimeterFormula = "2×π×r";
                break;
            case "Rectangle":
                perimeterFormula = "2×a+2×b";
                break;
            case "Triangle":
                perimeterFormula = "a+b+c";
                break;
            case "Square":
                perimeterFormula = "4×a";
                break;
            case "EquilateralTriangle":
                perimeterFormula = "3×a";
                break;
            case "RegularPentagon":
                perimeterFormula = "5×a";
                break;
            default:
                perimeterFormula = "No perimeter formula.";
        }
        return perimeterFormula;
    }
}
