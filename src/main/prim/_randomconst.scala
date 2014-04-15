// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim

import org.nlogo.core.Syntax
import org.nlogo.nvm.{ Context, Reporter}

class _randomconst(n: Long) extends Reporter {
  override def syntax2 =
    Syntax.reporterSyntax(
      ret = Syntax.NumberType)
  override def toString =
    super.toString + ":" + n
  override def report(context: Context): java.lang.Double =
    Double.box(report_1(context))
  def report_1(context: Context): Double =
    context.job.random.nextLong(n)
}
