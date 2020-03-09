/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package nashorn.api.tree;

import nashorn.internal.ir.ForNode;

final class ForLoopTreeImpl extends StatementTreeImpl implements ForLoopTree {
    private final ExpressionTree init;
    private final ExpressionTree cond;
    private final ExpressionTree update;
    private final StatementTree stat;

    ForLoopTreeImpl(final ForNode node,
        final ExpressionTree init,
        final ExpressionTree cond,
        final ExpressionTree update,
        final StatementTree  stat) {
        super(node);
        assert !node.isForIn() : "for statement expected";
        this.init = init;
        this.cond = cond;
        this.update = update;
        this.stat = stat;
    }

    @Override
    public Kind getKind() {
        return Kind.FOR_LOOP;
    }

    @Override
    public ExpressionTree getInitializer() {
        return init;
    }

    @Override
    public ExpressionTree getCondition() {
        return cond;
    }

    @Override
    public ExpressionTree getUpdate() {
        return update;
    }

    @Override
    public StatementTree getStatement() {
        return stat;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitForLoop(this, data);
    }
}