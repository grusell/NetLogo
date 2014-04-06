// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc

import org.nlogo.core.Syntax
import org.nlogo.api.LogoException
import org.nlogo.agent.Turtle
import org.nlogo.nvm.{ Context, Pure, Reporter }

class _subtractheadings extends Reporter with Pure {

  override def syntax =
    Syntax.reporterSyntax(
      right = List(Syntax.NumberType, Syntax.NumberType),
      ret = Syntax.NumberType)

  override def report(context: Context): java.lang.Double =
    Double.box(
      report_1(context,
               argEvalDoubleValue(context, 0),
               argEvalDoubleValue(context, 1)))

  def report_1(context: Context, h0: Double, h1: Double): Double =
    Turtle.subtractHeadings(h0, h1)

}
