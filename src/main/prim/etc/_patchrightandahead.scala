// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc

import org.nlogo.core.Syntax
import org.nlogo.api.{ AgentException, Nobody }
import org.nlogo.agent.Turtle
import org.nlogo.nvm.{ Context, Reporter }

@annotation.strictfp
class _patchrightandahead extends Reporter {

  override def syntax2 =
    Syntax.reporterSyntax(
      right = List(Syntax.NumberType, Syntax.NumberType),
      ret = Syntax.PatchType,
      agentClassString = "-T--")

  override def report(context: Context): AnyRef =
    try
      context.agent.asInstanceOf[Turtle]
        .getPatchAtHeadingAndDistance(
          argEvalDoubleValue(context, 0),
          argEvalDoubleValue(context, 1))
    catch { case _: AgentException => Nobody }

}
