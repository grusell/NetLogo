// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.prim.etc

import org.nlogo.core.Syntax
import org.nlogo.agent.Agent
import org.nlogo.nvm.{ Context, Reporter }

class _self extends Reporter {
  override def syntax2 =
    Syntax.reporterSyntax(
      ret = Syntax.AgentType,
      agentClassString = "-TPL")
  override def report(context: Context): Agent =
    report_1(context)
  def report_1(context: Context): Agent =
    context.agent
}
