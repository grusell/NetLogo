// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc

import org.nlogo.core.Syntax
import org.nlogo.nvm.{ Context, Pure, Reporter }

class _ifelsevalue extends Reporter with Pure {
  override def syntax2 =
    Syntax.reporterSyntax(
      right = List(
        Syntax.BooleanType,
        Syntax.ReporterBlockType,
        Syntax.ReporterBlockType),
      ret = Syntax.WildcardType)
  override def report(context: Context): AnyRef =
    if (argEvalBooleanValue(context, 0))
      args(1).report(context)
    else
      args(2).report(context)
}
