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

import java.util.List;

import nashorn.internal.ir.Block;
import nashorn.internal.ir.BlockStatement;

final class BlockTreeImpl extends StatementTreeImpl implements BlockTree {
    private final List<? extends StatementTree> statements;

    BlockTreeImpl(final BlockStatement node, final List<? extends StatementTree> statements) {
        super(node);
        this.statements = statements;
    }

    BlockTreeImpl(final Block node, final List<? extends StatementTree> statements) {
        super(node);
        this.statements = statements;
    }

    @Override
    public Kind getKind() {
        return Kind.BLOCK;
    }

    @Override
    public List<? extends StatementTree> getStatements() {
        return statements;
    }

    @Override
    public <R,D> R accept(final TreeVisitor<R,D> visitor, final D data) {
        return visitor.visitBlock(this, data);
    }
}
