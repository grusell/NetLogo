// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim

import org.nlogo.core.Syntax
import org.nlogo.api.Nobody
import org.nlogo.agent.{ Turtle, Patch }
import org.nlogo.nvm.{ Reporter, Context }

class _patchse extends Reporter {

  override def syntax2 =
    Syntax.reporterSyntax(
      ret = Syntax.PatchType,
      agentClassString = "-TP-")

  override def report(context: Context): AnyRef =
    report_1(context)

  def report_1(context: Context): AnyRef = {
    val result = world.topology.getPSE(
      context.agent match {
        case p: Patch => p
        case t: Turtle => t.getPatchHere
      })
    if (result == null) Nobody
    else result
  }

}
